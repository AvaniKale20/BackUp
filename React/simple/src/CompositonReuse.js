//import React from 'react';
import React,{Fragment} from 'react';
/*************using function********** */
export function Student1()
{
    return (
    <Fragment>
  <h1> Name are given</h1>
  <h4>avi</h4>
  <h4>vuish</h4>
  <h4>sam</h4>
  <h4>sunil</h4>
    </Fragment>
    );
}
export function Clg1()
{
    return(<div>
        <h1>Topper student in clg</h1>
        <Student1/>
    </div>

    );
}
/********** using optional********** */
export const Child=()=>{
    return(
<Fragment>
  <h1> Name=</h1>
  <h4>abc</h4>
  <h4>xyz</h4>
  <h4>aaa</h4>
  <h4>bbb</h4>
    </Fragment>
    );
}

export const Home=()=>{
    return(
        <div>
             <h1>Child....</h1>
        <Child/>
        </div>
    )
}
/***********usnig props******** */
export const Child1=(props)=>{
    return(
<h1>helloo {props.name}</h1>
    );
}

export const Home1=()=>{
    return(
        <div>
             <h1>Child....</h1>
        <Child1 name="arnav"/>
        <Child1 name="omkar"/>
        <Child1 name="ishan"/>
        </div>
    )
}
