import React, { Component } from 'react';

import Login from './Login';
import Logout from './Logout';

class MainPage extends Component {
  constructor()
  {
  	super()
  	this.state = {current_page : 'connexion', connected: false}
  	this.setState(this.state)
  	this.connect = this.connect.bind(this)
  	this.disconnect = this.connect.bind(this)
  }
  connect()
  {
  	this.setState({current_page : 'posts', connected: true})
  }
  disconnect()
  {
  	this.state.connected = false;
  	this.current_page = "connexion";

  }
  render()
  {

  switch(this.state.current_page) {
    case 'connexion':
      return <Login connect= {this.connect} />;
    case 'logout':
      return <Logout disconnect={this.disconnect} />;
    case 'posts':
      return <p> en cours de fabrication </p>;
    default:
      return null;
  }
}
}

export default MainPage;
