import React from 'react'
import { IHobbies } from '../Util/HobbiesUtils'
import './Hobbies.css'

interface IHobbiesProps {
    hobbies: IHobbies[];
  }
function Hobbies({hobbies}: IHobbiesProps){
  return (
    <div className='hobbies-div'>
    <h2 className='hobbies-title'>Hobbies:</h2>
    <ul>
      {hobbies.map((hobby, index) => (
        <li key={index} id='hobbies'>{hobby.hobby}</li>
      ))}
    </ul>
  </div>
  )
}

export default Hobbies