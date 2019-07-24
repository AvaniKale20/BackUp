import React, { Component } from 'react';
import PT from 'prop-types';
 class Students extends Component
{
    render()
    {
        return(
            <div>
                <h1>TypeCheacking</h1>
<h3>Hello{this.props.name} </h3>
<h3>RollNo:{this.props.roll}</h3>

            </div>
        )
    }
}
Students.propTypes={
    name: PT.string
};
export default Students;