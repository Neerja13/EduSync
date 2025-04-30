const RenderGrid = ({ seatRow, start, end }) => {
    const colHeights = seatRow.split('').map(Number); // e.g., [4, 5, 5, 5, 5]
    const startRoll = parseInt(start, 10);
    const endRoll = parseInt(end, 10);
    const rollNumbers = Array.from({ length: endRoll - startRoll + 1 }, (_, i) => startRoll + i);
  
    // Fill each column vertically with roll numbers
    const columns = colHeights.map(height => {
      const column = [];
      for (let i = 0; i < height; i++) {
        column.push(rollNumbers.length > 0 ? rollNumbers.shift() : null);
      }
      return column;
    });
  
    const maxRows = Math.max(...colHeights);
    const rows = Array.from({ length: maxRows }, (_, rowIndex) => {
      return columns.map((col, colIndex) => (rowIndex < col.length ? col[rowIndex] : null));
    });
  
    return (
      <div style={{ marginTop: '1rem' }}>
        <h3>Classroom Seating Grid</h3>
        {rows.map((row, rowIndex) => (
          <div key={rowIndex} style={{ display: 'flex', marginBottom: '0.5rem' }}>
            {row.map((cell, colIndex) => (
              <div
                key={colIndex}
                style={{
                  width: '40px',
                  height: '40px',
                  border: cell !== null ? '1px solid #555' : 'none',
                  backgroundColor: cell !== null ? '#dff0d8' : 'transparent',
                  display: 'flex',
                  alignItems: 'center',
                  justifyContent: 'center',
                  marginRight: '5px',
                  borderRadius: '4px',
                  fontSize: '12px',
                }}
              >
                {cell ?? ''}
              </div>
            ))}
          </div>
        ))}
      </div>
    );
  };
  
  
  export default RenderGrid;
  