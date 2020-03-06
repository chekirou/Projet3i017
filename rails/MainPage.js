import React, { Component } from 'react';
import axios from 'axios';
import Login from './Login';
import Logout from './Logout';
import Mur from './Mur'
import Inscription from './Inscription';
class MainPage extends Component {


  constructor() {
    super();
    this.state = { current_page: 'connexion', connected: false, key: "", login: "" };
    this.setState(this.state);
    this.connect = this.connect.bind(this);
    this.disconnect = this.disconnect.bind(this);
    this.goToSubscribe = this.goToSubscribe.bind(this);
    this.subscribe = this.subscribe.bind(this);
    
    
    
  }
  
  
 
  goToSubscribe()
  {
    this.setState({current_page : "inscription"})
  }

  connect({ login, password }) {
    
    console.log(login + " " + password)
  	axios.get("http://localhost:8080/RCTwister/User/Login?login=" + login + "&password=" + password).then(response => {
    
    if(Object.keys(response.data).length === 2 )
    {
      console.log(response.data["connexion"] + "  " + response.data["key"])
      this.setState({current_page: 'posts', login :  login,connected : true, key: response.data["key"] })
    }
    else{
      console.log("erreur")
    }
   
  	
  	});

  }
  subscribe({Lastname, Name, Login, pass, Sexe, Date_naissance, Email})
  {
    console.log(Lastname +" " + Name +" " +Login +" " + pass +" " + Sexe+" " + Date_naissance +" " + Email)
    axios.get("http://localhost:8080/RCTwister/User/Creation?nom=" + Lastname+ "&prenom="+Name+"&login="+Login+"&password="+pass+"&sexe="+Sexe+"&DOB="+Date_naissance+"&email="+Email).then(response =>
      { 
        console.log("execution ")
        console.log(response.data)
        console.log("execution ")
        

        if( "creation " in response.data &&  Object.keys(response.data).length === 1)
        {
          console.log(response.data["creation "]);
          this.setState({current_page: 'connexion', login :  Login,connected : false, key: "" });
        }
        else{
          alert("erreur " + response.data );
        }
      });
    
  }
  disconnect() {
    axios.get("http://localhost:8080/RCTwister/User/Logout?login=" + this.state.login + '&clef=' + this.state.key).then(response =>
      { 
        console.log("execution ")
        console.log(response.data)
        console.log("execution ")
        
        if( "deconnection" in response.data &&  Object.keys(response.data).length === 1)
        {
          console.log(response.data["deconnection"]);
          this.setState({current_page: 'connexion', login :  "",connected : false, key: "" });
        }
        else{
          alert("erreur " + response.data );
        }
      });

  }
  
  
  render() {
    switch (this.state.current_page) {
      case 'connexion':
        return <Login connect={this.connect} goToSubscribe={this.goToSubscribe}/>;
      case 'inscription':
        return <Inscription subscribe={this.subscribe} />
      case 'posts':
        return <div>
          
          <Mur disconnect={this.disconnect} login={this.state.login} clef={this.state.key}  />
        </div>

      default:
        return null;
    }
  }
}

export default MainPage;
