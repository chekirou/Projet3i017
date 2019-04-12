import React, { Component } from 'react';
import axios from 'axios';
import Login from './Login';
import Logout from './Logout';
import Mur from './Mur'
import Inscription from './Inscription';
class MainPage extends Component {


  constructor() {
    super();
    this.state = { current_page: 'posts', connected: false, key: "", login: "" };
    this.setState(this.state);
    this.connect = this.connect.bind(this);
    this.disconnect = this.disconnect.bind(this);
    this.goToSubscribe = this.goToSubscribe.bind(this);
    this.subscribe = this.subscribe.bind(this);
    this.addMessage = this.addMessage.bind(this);
	this.updatetweets = this.updatetweets.bind(this);
    
    this.tweets =[
                  {
                    pseudo:"hakim", 
                    image:"https://images.unsplash.com/photo-1518806118471-f28b20a1d79d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80",
                    message:"hello, ations de mise en page de texte, comme Aldus PageMaker"
                  },
				  {
                    pseudo:"hakim", 
                    image:"https://images.unsplash.com/photo-1518806118471-f28b20a1d79d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80",
                    message:"heùlknùlknùlknlknùlknlknaaaaaaaaaaaaaaaaaaa    klnkje ùlknùzlknvjeje,llo, ations de mise en page de texte, comme Aldus PageMaker"
                  }

                    
    ]
  }
  
  
  async getMessage(login)
  {
    axios.get("http://localhost:8080/RCTwister/Message/ListMessages?Login=" + login).then(response =>
      { 
        console.log("execution ")
        console.log(response.data)
        console.log("execution ")
        
        if( Object.keys(response.data).length === 1)
        {
          console.log(response.data);
          for( var i in response.data[login])
          {
            console.log(response.data[login][i]);
            this.tweets.push({pseudo : response.data[login][i]["name"][0], date : response.data[login][i]["date"][0], message: response.data[login][i]["message"][0] })
          }
        }
        else{
          alert("erreur " + response.data );
        }
      });
  }
  goToSubscribe()
  {
    this.setState({current_page : "inscription"})
  }

  connect({ login, password }) {
    
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
  addMessage(message) {
    axios.get("http://localhost:8080/RCTwister/Message/AddMessage?My_login=" + this.state.login + '&key=' + this.state.key + '&message=' + message).then(response =>
      { 
        console.log("execution ")
        console.log(response.data)
        console.log("execution ")
        

        if( "ajout du message" in response.data &&  Object.keys(response.data).length === 1)
        {
          console.log("ajout du message");
        }
        else{
          alert("erreur " + response.data );
        }
      });
  }
	async updatetweets(login)
	{
		await this.getMessage(login)
	}
  render() {
    switch (this.state.current_page) {
      case 'connexion':
        return <Login connect={this.connect} goToSubscribe={this.goToSubscribe}/>;
      case 'inscription':
        return <Inscription subscribe={this.subscribe} />
      case 'posts':
        /*this.updatetweets(this.state.login);*/
        console.log("les tweets");
        console.log(this.tweets);
        return <div>
          
          <Mur disconnect={this.disconnect} login={this.state.login} clef={this.state.key} tweets={this.tweets} />
        </div>

      default:
        return null;
    }
  }
}

export default MainPage;
