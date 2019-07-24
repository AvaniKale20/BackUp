import React, { Component ,Fragment} from 'react';

export  function User   (props){
  
    return(
        <Fragment>
            <h2>Welcome Person...</h2>
            <button>LogOut</button>
        </Fragment> 

    )
    }
export  function Guest  (props) {
    return(
    <Fragment>
    <h2>Welcome....  </h2>
     <button> sign up</button>

</Fragment> 
    )
     
  
}
export function Greeting(props)
{
    const isLoggin=props.isCOndition;
    if(isLoggin)
    {
        return <User/>
    }
    return <Guest/>
}
/************************* */
// export function MailBox(props)
// {
//     const MsgSendOrNo=props.msgSendOrNot;
    
//     if(MsgSendOrNo)
//     {return(
//       <Fragment>
//           <h1>Checking ur msg send or not</h1>
//           (MsgSendOrNo && <)
//       </Fragment> 
//     ) 
//     }
// }