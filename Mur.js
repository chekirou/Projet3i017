import React, { Component } from 'react';

import axios from 'axios';
import NewsFeed from './NewsFeed'
import Topbar from './Topbar'
import Profil_square from './Profil_square'
import NewMessage from './NewMessage'
import Follow from './follow'
import Users from './Users'
import image from './profil_homme.png'
import './Mur.css';
class Mur extends Component {
  constructor(props)
  {
	  super(props);
	  this.addMessage = this.addMessage.bind(this);
      this.updateMessage = this.updateMessage.bind(this);
      this.updatePersonalMessage = this.updatePersonalMessage.bind(this);
	  this.getInfos = this.getInfos.bind(this);
	  this.goToUser = this.goToUser.bind(this);
	  this.follow = this.follow.bind(this);
		this.goHome = this.goHome.bind(this);
		this.searchPeople = this.searchPeople.bind(this);
		this.delete = this.delete.bind(this);
	  //this.getListAmis = this.getListAmis.bind(this);
	  this.tweets =[]
	  this.infos={}
	  this.users = {};
	  this.state = {infos : this.infos, personnal : true, mur: true, search: false};
	}
	delete(id_message)
	{
		
    axios.get("http://localhost:8080/RCTwister/Message/DeleteMessage?My_login=" + this.props.login + "&key=" + this.props.clef+ "&MessageId=" + id_message).then(response =>
      { 
        
        console.log(response.data)
        
        
        if( Object.keys(response.data).length === 1)
        {
					this.updatePersonalMessage(this.props.login);
					this.getInfos(this.props.login);
        }
        else{
          alert("erreur " + response.data );
        }
      });
	}
	searchPeople(mot)
	{
		console.log("le search")
    axios.get("http://localhost:8080/RCTwister/Search?mot=" + mot).then(response =>
      { 
        
        console.log(response.data)
        
        
        if( Object.keys(response.data).length === 1)
        {
		  	console.log(response.data);
		  	this.users= [];
          for( var i in response.data["users"])
          {
            //console.log(response.data["user"][0]);
            this.users.push({pseudo : response.data["users"][i]});
					}
		  this.setState({search : true, users: this.users})
        }
        else{
          alert("erreur " + response.data );
        }
      });
	}
  goToUser(login)
  {
    this.getInfos(login);
	this.updatePersonalMessage(login);
	this.setState({personnal : this.props.login === login, mur : false, search: false});
  }
  addMessage(message) {
    axios.get("http://localhost:8080/RCTwister/Message/AddMessage?My_login=" + this.props.login + '&key=' + this.props.clef + '&message=' + message).then(response =>
      { 
        
        console.log(response.data)
        
        

        if( "ajout du message" in response.data &&  Object.keys(response.data).length === 1)
        {
		  console.log("ajout du message");
		  this.updateMessage(this.props.login);
        }
        else{
          alert("erreur " + response.data );
        }
      });
  }	
  updateMessage(login)
  {
    console.log("le get message")
    axios.get("http://localhost:8080/RCTwister/Message/ListMixMessages?Login=" + login).then(response =>
      { 
        
        console.log(response.data)
        
        
        if( Object.keys(response.data).length === 1)
        {
		  console.log(response.data);
		  this.tweets= [];
          for( var i in response.data["les messages"][0])
          {
            console.log(response.data["les messages"][0]);
            this.tweets.push({pseudo : response.data["les messages"][0][i]["author_name"], date : response.data["les messages"][0][i]["date"], message: response.data["les messages"][0][i]["message"], id_message : response.data["les messages"][0][i]["_id"]  })
		  }
		  this.getInfos(this.props.login);
		  this.setState({tweets : this.tweets})
        }
        else{
          alert("erreur " + response.data );
        }
      });
     
  }
  updatePersonalMessage(login)
  {
    console.log("le get message")
    axios.get("http://localhost:8080/RCTwister/Message/ListMessages?Login=" + login).then(response =>
      { 
        
        console.log(response.data)
        
        
        if( Object.keys(response.data).length === 1)
        {
		  console.log(response.data);
		  this.tweets= [];
          for( var i in response.data["les messages"][0])
          {
            console.log(response.data["les messages"][0]);
            this.tweets.push({pseudo : response.data["les messages"][0][i]["author_name"], date : response.data["les messages"][0][i]["date"], message: response.data["les messages"][0][i]["message"], id_message : response.data["les messages"][0][i]["_id"]  })
		  }
		  this.getInfos(this.infos.login);
		  this.setState({tweets : this.tweets})
        }
        else{
          alert("erreur " + response.data );
        }
      });
     
  }
  getInfos(login)
  {
	axios.get("http://localhost:8080/RCTwister/User/Info?login=" + login).then(response =>
	{ 
	  console.log(response.data)
	  
	  
	  if( Object.keys(response.data).length === 2)
	  {
		console.log("les infos ");
		this.infos= {};
		console.log(response.data["infos"]);
		this.infos.login = login;
		this.infos.twists=  response.data["stats"][0]["nbMessages"][0];
		this.infos.abonements = response.data["stats"][0]["follows"][0];
		this.infos.abonnés= response.data["stats"][0]["subs"][0];
		this.infos.nom= response.data["infos"][1];
		this.infos.prenom= response.data["infos"][0];
		this.infos.DOB= response.data["infos"][3];
		this.infos.email= response.data["infos"][4];
		this.infos.sexe= response.data["infos"][2];
		console.log(this.infos)
		this.setState({infos : this.infos})
	  }
	  else{
		alert("erreur " + response.data );
	  }
	});
  }	
  goHome()
  {
	this.updateMessage(this.props.login);
	this.getInfos(this.props.login);
	this.setState({personnal: true, mur: true})
  }
  componentWillMount()
  {
	
	this.updateMessage(this.props.login);
	this.getInfos(this.props.login);

  }
  follow(login)
  {
	axios.get("http://localhost:8080/RCTwister/Friend/AddFriend?My_login=" + this.props.login + "&His_login=" + login + "&key="+ this.props.clef).then(response =>
	{ 
	  
	  console.log(response.data)
	  
	  
	  if( Object.keys(response.data).length === 1)
	  {
		this.getInfos(login);
		this.setState({friends: true});
	  }
	  else{
		alert("erreur " + response.data );
	  }
	});
  }
  render()
  {
  	return (
  		<div className="tout">
  			<Topbar signOut={this.props.disconnect} goHome={this.goHome} search={this.searchPeople}/>
  			<div className="part2">
  			<div className="side">
  				<Profil_square
  				profilPic={ image}
  				nom={this.state.infos.nom}
  				prenom = {this.state.infos.prenom}
  				login={this.state.infos.login}
  				twists={this.state.infos.twists}
  				abonements = {this.state.infos.abonements}
  				abonnés={this.state.infos.abonnés}
  				 />
  			</div>
  			<div className="main">
  			{this.state.search ? <Users users={this.users} goUser={this.goToUser} />: <NewsFeed tweets={this.tweets} goUser={this.goToUser} delete={this.delete}/>}
  			</div>
  			{this.state.personnal? 
			  
			  <div className="nouveau">
  				<NewMessage sendMessage={this.addMessage}/>
				  </div>
				  :
				  <Follow  follow={this.follow} login={this.infos.login} />}
  			</div>
  			
  		</div>
  		)
  }


}
export default Mur;