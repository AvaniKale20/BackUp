import React, { Component } from 'react';
import { TextField, Card, Button } from '@material-ui/core';

import {withRouter} from 'react-router-dom'


 class LoginUser extends Component {
    constructor(props) {
        super(props);
        this.state = {
            UserName: " ",
            PassWord: " "
        }
    }

    RegisterMethod=()=>{
        this.props.history.push('/register')
}

    render() {
        return (
            <div>

                    <Card >
                        <div>
                            <div>
                                <h1>UserLogin</h1>
                            </div>
                            <div> <TextField
                                id="outlined-password-input"
                                label="UserName"

                                type="UserName"
                                autoComplete="current-password"
                                margin="normal"
                                variant="outlined"
                            />

                                <TextField
                                    id="outlined-password-input"
                                    label="PassWord"

                                    type="PassWord"
                                    autoComplete="current-password"
                                    margin="normal"
                                    variant="outlined"
                                />
                            </div>

                            <div className="loginButton">

                                <Button label="Login" >Login</Button>
                                <Button label="Reg" onClick={this.RegisterMethod}> Fill the registration Form</Button>
                            <Button label="ForgetPassword" onClick={this.ForgetPassWord}>ForgetPassword</Button>
                            </div>

                        </div>
                    </Card>

            </div>
        );
    }

 }
export default LoginUser