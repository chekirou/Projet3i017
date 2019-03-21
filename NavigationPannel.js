import React, { Component } from 'react';
import Login from './Login';
import Logout from './Logout';
class NavigationPannel extends Component {
  constructor(props)
  {
  	super(props);
  	this.state = {login : props.login,logout : props.logout,isConnected : props.isConnected }
  }
  render() {
    if(this.state.isConnected)
    {
    	return (<nav> <Login attribut={this.state.login} /> </nav>);
    }
    else
    {
    	return( <nav> <Logout attribut={this.state.logout} /> </nav>);
    }
  }
}

export default NavigationPannel;
