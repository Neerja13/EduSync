import React, { useState } from 'react'
import {createClassRoom} from '../api/classRoomApi'

function CreateClassRoom() {
    const [form,setForm] = useState({class_no: '', seat_row: ''});
    const [message,setMessage] = useState('');

    const handleChange = (e) =>{
        setForm({...form,[e.target.name] : e.target.value});
    }

    const handleCreate = async () =>{
        try {
            const response = await createClassRoom(form);
            setMessage(response.data);
        } catch (error) {
            setMessage(error.response?.data || 'Error occurred');
        }
    }
  return (
    <>
        <div>
            <h2>Create ClassRoom</h2>
            <input type="text" required placeholder='Enter the Class Room Number : ' name='class_no' onChange={handleChange} />
            <input type="text" required placeholder='seatRow example ? 4452' name='seat_row' onChange={handleChange}/>
            <button onClick={handleCreate}>Create</button>
            {message && <p>{message}</p>}
        </div>
    </>
  )
}

export default CreateClassRoom;