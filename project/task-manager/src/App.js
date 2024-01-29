import React, { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    fetch('localhost:8000/index.php')
      .then((response) => response.json())
      .then((data) => setTasks(data))
      .catch((error) => console.error('Error fetching tasks:', error));
  }, []);

  return (
    <div className="container mx-auto mt-8">
      
      <header class="bg-black absolute inset-x-0 top-0 rounded-sm">
        <h1 className="text-2xl font-bold m-4  text-white">Task Manager</h1>
        <h4 className='absolute inset-y-0 right-0 m-4 text-white'>Mikalai Holias</h4>
      </header>

      <ul>
        {tasks.map((task) => (
          <li
            key={task.id}
            className={`mb-2 p-2 ${task.completed ? 'line-through text-gray-500' : ''}`}
          >
            {task.title}
          </li>
        ))}
      </ul>

      

      
    </div>
  );
}

export default App;
