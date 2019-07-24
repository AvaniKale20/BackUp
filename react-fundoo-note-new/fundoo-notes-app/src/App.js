import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom'
import  { Component } from 'react';
import Register from './pages/Register'
class App extends Component
{
  render()
  {
    return(
      <div>
        <Router>
          <Route path="/register" component={Register}></Route>
          <Route path="/login" component={Login}></Route>
          </Router>
      </div>
    )
  }

}

export default App;
