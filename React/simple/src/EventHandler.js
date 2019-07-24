import React, { Component } from 'react';
export class Shape extends Component{
    constructor(props)
    {
     //adding parent class
        super(props);
        this.afterClicked=this.afterClicked.bind(this);

        
    }
    //not need to write function keyword here bcz we r writting function inside a class
    afterClicked()
    {
        console.log("after button clicked",this);
    }
    // afterClicked=()=>
    // {
    //    return console.log("after button clicked",this);
    // }
    render()
    {
        return(
            //parent <div>
            //in <div> childerns
            <div>
                //childerns
                <h3>---------------</h3>
                <h1>About event......</h1>
                <button onClick={this.afterClicked}>clickHere</button>
            </div>
        )
    }
}