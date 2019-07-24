import React from 'react';
import ReactDOM from 'react-dom';
import Student from './Student';
import Student1 from './Student'
//import { Student1, App12 } from './Student';
// import el1 from "./App";

// import el from "./App";

// // import * as serviceWorker from './serviceWorker';

// //ReactDOM.render(el,document.getElementById("root"))
// ReactDOM.render(el1,document.getElementById("root"))
//ReactDOM.render(element,document.getElementById('root'));
ReactDOM.render(<Student name="avani"/>,document.getElementById("one"));
ReactDOM.render(<Student1 name="avani"/>,document.getElementById("one"));
// ReactDOM.render(<Student name="avani"/>, document.getElementById("one"));
// ReactDOM.render(<App12 name="avani"/>, document.getElementById("one"));