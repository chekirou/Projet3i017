import React, { Component } from 'react';

import axios from 'axios';
import NewsFeed from './NewsFeed'
import Topbar from './Topbar'
import Profil_square from './Profil_square'
import NewMessage from './NewMessage'
import Follow from './follow'
import Users from './Users'
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
		console.log("le delete")
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
  				profilPic={"data:image/png;base64,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"}
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