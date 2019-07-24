import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App.js';
import {Student,Clg} from './Component';
import {Student1,Clg1} from './CompositonReuse';
import {Child,Home} from './CompositonReuse';
import {child1,Home1}from './CompositonReuse';
import {Employe,Emp} from './ChildrenJsx';
import Students from './Props';
import{SalesManager,Hr} from './State';
import {Shape} from './EventHandler'
import {List} from './List'
import {Users} from './List'
import {Guest,User,Greeting} from './Conditional'
// import {MailBox} from './Conditional'
import {Main} from './Login'
//1st for only one default
ReactDOM.render(<App/>, document.getElementById('root'));
//
ReactDOM.render(<Student/>,document.getElementById('root1'));
ReactDOM.render(<Clg/>,document.getElementById('root2'));
//
ReactDOM.render(<Clg1/>,document.getElementById('root3'));
//
ReactDOM.render(<Home/>,document.getElementById('root4'));
//
ReactDOM.render(<Home1/>,document.getElementById('root5'));

ReactDOM.render(<Employe>I am Employe from Bridglabzs</Employe>,document.getElementById('root6'));

ReactDOM.render(<Emp>I am Employe from Bridglabzs</Emp>,document.getElementById('root7'));

ReactDOM.render(<Students name={158} roll="1234"/>,document.getElementById('root8'));

ReactDOM.render(<SalesManager id="12"/>,document.getElementById('root9'));

ReactDOM.render(<Hr id="13"/>,document.getElementById('root10'));
ReactDOM.render(<Shape/>,document.getElementById('root11'));
ReactDOM.render(<List/>,document.getElementById('demo'));
ReactDOM.render(<Users/>,document.getElementById('demo1'));
ReactDOM.render(<Greeting isCOndition={false}/>,document.getElementById('demo2'));
// ReactDOM.render(<MailBox msgSendOrNot={true}/>,document.getElementById('demo3'));
ReactDOM.render(<Main/>,document.getElementById('demo4'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA

