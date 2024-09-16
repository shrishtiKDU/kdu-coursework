import React from "react";
import Skills from "./Skills";
import Hobbies from "./Hobbies";
import Headers from './Headers';
import { ISkill } from "../Util/SkillUtils";
import { IHeader } from "../Util/HeaderUtils";
import { IHobbies } from "../Util/HobbiesUtils";
import './Profile.css'

interface IProfileitems {
    name: string,
    fullName: string,
    qualification: string,
  skills: ISkill[];
  hobbies: IHobbies[];
}

interface IProfile{
    profileList:IProfileitems[]
}

function Profile({profileList}:IProfile) {
  return (
    <div>
        {profileList.map((item)=>{
            return(
                <div className="main-dev">
<Headers name={item.name} qualification={item.qualification} fname={item.fullName} />

        <div className="section-div">
            <div className="skill-div">
            <Skills  skills={item.skills} />
            </div>
            <div className="hobby-div">
            <Hobbies hobbies={item.hobbies}/>
            </div>
        
      </div>
            </div>
     
      )
    })
}
    </div>
  )
}

export default Profile;
