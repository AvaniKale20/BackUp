import React, { Component } from 'react';
import Registration from '../components/registration'
import {withRouter} from 'react-router-dom'

 class Register extends Component {
  render() {
    return (
      <div>
        <Registration></Registration>
      </div>
    );
  }
}
export default withRouter(Register)
