import React from 'react'
import './Header.css'

interface ListItemProps{
    name:string;
    qualification: string;
    fname: string;
}

function Headers({name, qualification, fname }:ListItemProps) {
  return (
    <div className='header-div'>
      <div className='header-div-div'>
        <div className='header-txt'>{name}</div>
      <div className='header-txt'> {qualification}</div>
      <div className='header-txt'>{fname}</div>
    </div>
    </div>
  )
}

export default Headers