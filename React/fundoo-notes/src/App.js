import React,{Component} from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom'
// import {Register} from './pages/register'
import Register from './pages/register'
import Demoo from './pages/demoo'



class App extends Component {
  render() {
    return (
      <div>
        <Router>
          <div>
          <Route path="/demoo" component={Demoo}>

          </Route>
          </div>
        </Router>

      </div>
        
     
    );
  }
}

export default App;
