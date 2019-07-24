import React from 'react';
import './App.css';
//by function
function show(name)
{
return name;
}

const el=<h1>helloo {show("sonam")}</h1>

//bye creating object
let user={
  firstName:"avani"
};

const el1=<h1>Hello {user.firstName}</h1>

//we want to use el element in index.js for that
// need to export it
export default el1;
//export default el1;

// import React from 'react';
// import ReactDOM from 'react-dom';
// function one()
// {
//     const element=(
//         <div>
//             <h1>how r u</h1>
//             <h1> its is {new Date().toLocaleTimeString()}.</h1>
//         </div>
//     );
//     // ReactDOM.render(element,document.getElementById('root'));
// }
// setInterval(one, 1000);

