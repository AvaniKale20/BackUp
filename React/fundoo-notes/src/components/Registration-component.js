import React, { Component } from 'react';

import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';

export class RegisterScreen extends Component {
    constructor(props) {
        super(props);

        this.state = {
            UserFirstName: " ",
            UserLastName: " ",
            MobileNo: " ",
            Password: " "

        }
    }

    render() {
        return (
            <div>
                <MuiThemeProvider>
                <div>

                    <AppBar title="New Resistration for user" />


                    <TextField type="UserFirstName"
                        hintText="Enter Your First Name here"
                    />

                    <br />

                    <TextField type="UserLastName"
                        hintText="Enter your Last Name here"
                    />

                    <br />


                    <TextField type="MobileNo"
                        hintText="Enter your Mobile here"
                    />


                    <br />

                    <TextField type="Password"
                        hintText="Enter your Password here"
                    />
                    <br />
                    <button > Register</button>


                </div>
                </MuiThemeProvider>
            </div>

        );
    }
}

