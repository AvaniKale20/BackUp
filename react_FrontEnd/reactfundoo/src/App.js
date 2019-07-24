import logo from './logo.svg';
import './App.css';
import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom'
import Register from './pages/register'
import Login from './pages/login'

 class App extends Component {
  render() {
    return (
      <div>
        <Router>
          
          <Route path="/register" component={Register}></Route>
            <Route path="/login" component={Login}></Route>

        </Router>
      
      </div>
    );
  }
}

export default App;
