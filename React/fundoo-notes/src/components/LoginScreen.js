import React, { Component,Fragment } from 'react';

import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';

export class Login extends Component{
    constructor(props){
        super(props);
    this.state={
        Username:" ",
        PassWord:" "
    }
    }

    render() {
        return (
            <div>
            <MuiThemeProvider>
              <div>

              <AppBar
                 title="Login"
               />
               <TextField
                 type="Username"
                 hintText="Enter your Username"
                
                 />
               <br/>
                 <TextField
                   type="Password"
                   hintText="Enter your Password"
                  
                   
                   />
                 <br/>
                 <RaisedButton label="Submit"  style={style} />
                </div>
        </MuiThemeProvider>
          </div>
        );
      }
    }
    const style = {
     margin: 15,
    };

