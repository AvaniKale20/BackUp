import React from 'react'
//function level 
export function Employe(props)
{
    return( <h1>Hi I am XYZ...{props.children}</h1>)
}

export class Emp extends React.Component{
    render()

    {
        return <h1> Hi I am XYZ...{this.props.children}</h1>
    }
}