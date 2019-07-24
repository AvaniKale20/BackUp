import React, { Component,Fragment } from 'react';

export  class User extends Component {
  render() {
    return (
      <Fragment>
          <h1>--------------------New Project !!1-------------------------</h1>
          <h3>"Welcome PersonName"</h3>
          <button onClick={this.props.clickData}>LogOut</button>

      </Fragment>
    );
  }
}

export  class Guest extends Component {
  render() {
      return(
    <Fragment>
    <h1>--------------------New Project !!1-------------------------</h1>
    <h3>"Welcome ...."</h3>
    <button onClick={this.props.clickData}>LogIn</button>
    <button>SingUp</button>

</Fragment>
    );
  }
}

export class Main extends Component{
    state={
        //initialy  value assing false
        isLoggedIn:false //true
    }
clickLogin=()=>
{
this.setState({isLoggedIn:true})
}
clickLogout=()=>
{
this.setState({isLoggedIn:false})
}
    render()
    {
        const isLoggedIn=this.state.isLoggedIn;
       
           
if(isLoggedIn)
{return <User clickData={this.clickLogout}/>
}
return <Guest clickData={this.clickLogin}/>

            
        
    }
}