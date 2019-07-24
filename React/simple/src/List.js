import React, { Component,Fragment } from 'react';
// 1st part 
export  class List extends Component {
  render() {
      const arr=[10,20,30,40];
      var newArray=arr.map((value) =>{
          console.log(value);
          return <li> { value*2}</li>

      } )
      console.log("old array=",arr)//this are elements (10,20,....)
      console.log("new array=",newArray)//(object  )
    return (

        <Fragment>
                    
<h1>-----</h1>
<h3>map </h3>

<ul>{newArray}
  </ul>
        </Fragment>
        
    );
  }
}
/****************
 * render()*
 *{
     const arr=[12,22,33,44]
     return(
         <ul>arr.map( value => <li>{value*2}</li>) </ul>
     )
 }** */
//2nd part

export  class Users extends Component {
    state={
        users:[
            {id:101, name:"avani" , add:"xyz"},
            {id:102, name:"aman" , add:"abc"},
            {id:103, name:"sam" ,add:"dfg"},
        ]
        };
    
  render() {
      const newUser=this.state.users.map(userValue=>
        {
            console.log(userValue);
            return(
            <h1  key={userValue.id}>
             Id:{userValue.id}, Name:{userValue.name}, Address:{userValue.add}
            </h1>
      )
        })
    return <div> {newUser}</div>
    
        
      
    
  }
}
