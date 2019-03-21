import React, { Component } from 'react';
import NavigationPannel from './NavigationPannel';
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
      <div><NavigationPannel login={this.getConnected} logout={this.setLogout} isConnected= {this.state.connecté}/> 
      </div>
    );
  }
}

export default MainPage;
