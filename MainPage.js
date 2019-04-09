import React, { Component } from 'react';
import axios from 'axios';
import Login from './Login';
import Logout from './Logout';
import Mur from './Mur'
class MainPage extends Component {
  

  constructor()
  {
  	super()
  	this.state = {current_page : 'connexion', connected: false, key:"", connexion:""}
  	this.setState(this.state)
  	this.connect = this.connect.bind(this)
  	this.disconnect = this.disconnect.bind(this)
    this.tweets =[
                  {
                    pseudo:"hakim", 
                    image:"https://images.unsplash.com/photo-1518806118471-f28b20a1d79d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80",
                    message:"hello, ations de mise en page de texte, comme Aldus PageMaker"
                  }

                    
    ]
  }

  connect({login, password})
  {
  	
  	/*axios.get('https://www.google.com/search?q=twister&ie=utf-8&oe=utf-8&client=firefox-b-e').then(response => {
  	this.setSate({current_page: response.data["connexion"] === 'ok' ? 'posts' : 'login'})
  	
  	});*/

  }
  disconnect()
  {

  	alert("deconnect login : " + this.statelogin + " | key : " + this.state.key)
    /*const logs = axios.get('http://localhost:8080/Twister/User/Logout?login=' + login + '&key=' + key)
    
    if(logs.connexion == "ok")
    {
      */
      this.setState({current_page : 'connexion', connected: false})
    /*}
    else
    {
      alert("deconnexion echouée")
      
    }*/

  }
  addMessage(message)
  {
    
  }
  render()
  {
  switch(this.state.current_page) {
    case 'connexion':
      return <Login connect= {this.connect} />;
    case 'posts':
      return <div>
                  <Mur disconnect={this.disconnect} login={this.state.login} clef={this.state.key} tweets={this.tweets}/>
              </div>

    default:
      return null;
  }
}
}

export default MainPage;
