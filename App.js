import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class MainPage extends Component {
  constructor()
  {
  	super();
  	this.state = {page_Courante : 'connexion', connecté: false};
  	this.getConnected = this.getConnected.bind(this);
  	this.setLogout = this.setLogout.bind(this);
  }
  getConnected()
  {
  	this.state.connecté = true;
  	this.state.connexion = 'mur';
  	
  }
  setLogout()
  {
  this.state.page_Courante = 'connexion'
  this.state.connecté = false;
  
  }
  render() {
    return (
      <div>{this.state.page_Courante} 
      </div>
    );
  }
}

export default MainPage;
