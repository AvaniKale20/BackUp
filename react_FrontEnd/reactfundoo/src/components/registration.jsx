import React, { Component } from 'react';
import { TextField, Card, Button } from '@material-ui/core';
import { MuiThemeProvider, createMuiTheme } from '@material-ui/core';
import {withRouter} from 'react-router-dom'
// import login from './login';
// import Login from '../pages/login';


// var theme = createMuiTheme({
//   overrides: {
//     MuiCard: {
//       root: {
//         "overflow": "hidden",
//         "width": "554px",
//         "margin-left": "336px",
//         "margin-top": "95px",
//         "display": "flow-root",
//         "padding-left": "124px",

//       }

//     }

//   }

// })


 class Registration extends Component {
  constructor(props) {
    super(props);

    this.state = {
      UserName: ' ',
      UserFirstName: " ",
      UserLastName: " ",
      MobileNo: " ",
      Password: " "

    }
  }

  
  LoginMethod=()=>{
    this.props.history.push('/login')
  }
  render() {
    console.log(" first name"+this.state.UserFirstName);
    

    return (
      <div>
        {/* <MuiThemeProvider theme={theme}> */}

          <Card className="cardRegister">
           
            <div>
              <h1>Fundoo Notes</h1></div>
            
            <div> <TextField
              id="outlined-password-input"
              label="First-Name"
             value={this.state.UserFirstName}
              type="First-Name"
              autoComplete="current-password"
              margin="normal"
              variant="outlined"
              onChange={(text)=>{this.setState({UserFirstName:text})}}
            />

              <TextField
                id="outlined-password-input"
                label="Last-Name"

                type="Last-Name"
                autoComplete="current-password"
                margin="normal"
                variant="outlined"
              />
            </div>

            <div>  <TextField
              id="outlined-password-input"
              label="UserName"
              type="UserName"
              autoComplete="current-password"
              margin="normal"
              variant="outlined"
            />
              <TextField
                id="outlined-password-input"
                label="Password"

                type="password"
                autoComplete="current-password"
                margin="normal"
                variant="outlined"
              /></div>
            <div>
              <Button label="Submit"> submit</Button>
              <Button label="Login" onClick={this.LoginMethod}>Login</Button>
            </div>


          </Card>
        {/* </MuiThemeProvider> */}
     
      </div>
    );
  }
}
export default withRouter(Registration)