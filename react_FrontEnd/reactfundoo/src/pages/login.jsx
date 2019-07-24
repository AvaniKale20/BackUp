import React, { Component } from 'react';
// import Registration from '../components/registration'
import LoginUser from '../components/login';
import {withRouter} from 'react-router-dom'
  class Login extends Component {
  render() {
    return (
      <div>
        <LoginUser ></LoginUser>
      </div>
    );
  }
}
export default Login;