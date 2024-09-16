import React from 'react'
import { ISkill } from '../Util/SkillUtils';
import './Skills.css'

interface ISkillsProps {
    skills: ISkill[];
  } 
function Skills({skills}: ISkillsProps) {
  return (
    <div className='skill-div'>
    <h2 className='skill-title'>Skills</h2>
    <ul>
      {skills.map((skill, index) => (
        <li key={index} id='skill'>{skill.skill}</li>
      ))}
    </ul>
  </div>
  )
}

export default Skills