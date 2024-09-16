import React from 'react';
import logo from './logo.svg';
import Profile from './component/Profile';
import './App.css';

function App() {

  const myData =[{
    "name": "Amey",
    "fullName": "Amey Aditya",
    "qualification": "SSE",
    "skills": [
        {
            "id": 1,
            "skill": "Python"
        },
        {
            "id": 2,
            "skill": "React"
        }
    ],
    "hobbies": [
        {
            "id": 1,
            "hobby": "Cricket"
        }
    ]
}]


  return (
    <div className="App">
   
        <Profile profileList={myData} />
    
      
    </div>
  );
}

export default App;
