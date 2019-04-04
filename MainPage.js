import React, { Component } from 'react';
import axios from 'axios';
import Login from './Login';
import Logout from './Logout';
import Mur from './Mur'
class MainPage extends Component {
  constructor()
  {
  	super()
  	this.state = {current_page : 'connexion', connected: false, key:""}
  	this.setState(this.state)
  	this.connect = this.connect.bind(this)
  	this.disconnect = this.connect.bind(this)
  }

  connect(x)
  {
  	alert(x)
  	//const logs = axios.get('localhost:8080/login=' +{login} +"&password="+ {login})
  	
  	/*if(logs.connexion == "ok")
  	{
  		this.setState({current_page : 'posts', connected: true, key:this.logs.key })
  	}
  	else
  	{
  		alert("login ou mot de passe faux")
  	}
  	*/
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
      return <div>
                  <Mur/>
              </div>

    default:
      return null;
  }
}
}

export default MainPage;
