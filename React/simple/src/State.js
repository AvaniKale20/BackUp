import React, { Component,Fragment } from 'react';

export class SalesManager extends Component
{ //this state accecible within class
    state={
        name:"Dinesh",
        sal:2000,
        //we can try through props in state 
        //props is read only we cant change props value 
        /******* we access <SalesManager id="12"/> using "this.props.id"
         * and pass into state "id" we can change the value now
         */
        id:this.props.id
    }

    render()
    {
        return(
    <Fragment>
        
 <h2> HHello i am{this.state.name} salary is {this.state.sal} id is {this.state.id}</h2>

    </Fragment>
       )

    }
}

export class Hr extends Component{
    constructor(props)
    {
        super(props);
        this.state={
        name:"rakesh",
        sal:30000,
        id:this.props.id
        }
    }
    render()
    {
        return(
            <Fragment>
                <h1> Hr name is {this.state.name} sal is {this.state.sal} HR id {this.state.id}</h1>
            </Fragment>
        )
    }

    }
