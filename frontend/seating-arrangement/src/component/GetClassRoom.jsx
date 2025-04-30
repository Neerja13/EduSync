import React, { useState } from 'react'
import { getClassRoom } from '../api/classRoomApi';
import RenderGrid from './RenderGrid';

function GetClassRoom() {

    const [classNo,setClassNo] = useState('');
    const [data,setData] = useState(null);
    const [message,setMessage] = useState('');
    const [start,setStart] = useState(0);
    const [end,setEnd] = useState(0);

    const handleFetch = async () =>{
        try {
            const response = await getClassRoom(classNo);
            setData(response.data);
            setMessage('');
        } catch (error) {
            setData(null);
            setMessage(error.response?.data || 'Error fetching data');
        }
    }

  return (
    <>
    <div>
      <h2>Get ClassRoom</h2>
      <input
        type="text"
        value={classNo}
        onChange={(e) => setClassNo(e.target.value)}
        placeholder="Enter Class No"
      />
      <h3>Enter the Starting and Ending Enrollment Number last three digit only!</h3>
      <input type="text" required placeholder='Enter Starting Enrollment Number last three digit' onChange={(e)=> setStart(e.target.value)} />
      <input type="text" required placeholder='Enter Ending Enrollment Number las three digit' onChange={(e)=> setEnd(e.target.value)}/>
      <button onClick={handleFetch}>Fetch</button>

      {message && <p>{message}</p>}

      {data && (
        <div style={{ marginTop: '1rem' }}>
        
          <p><strong>Class No:</strong> {data.class_no}</p>
          <p><strong>Seat Row:</strong> {data.seat_row}</p>
          <p><strong>Single Capacity:</strong> {data.singleCapacity}</p>
          <p><strong>Double Capacity:</strong> {data.doubleCapacity}</p>
          <p><strong>Occupied:</strong> {data.isOccupied ? 'Yes' : 'No'}</p>

          {RenderGrid({ seatRow: data.seat_row, start: start, end: end })}
        </div>
      )}
    </div>
    </>
  )
}

export default GetClassRoom;