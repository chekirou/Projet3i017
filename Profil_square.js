import React, { Component } from 'react';
import './profil_square.css';
class Profil_square extends Component {
  constructor(props)
  {
  	super(props);
  }
render()
{

	return (
	<div className="profil_square">
	    <div className="contenu_profil">

	        <div className="avatar" >
	        	<img className="photo_profil" src={this.props.profilPic}/>
	        	<div className="infos_utilisateur">
		        	<div className="nomPrenom">
		          		<a className="lien_nP" href="">{this.props.nom} {this.props.prenom}</a>
		        	</div>
		        	<span className="pseudo">
		          		<a className="lien_pseudo" href="" >{this.props.login}</a>
		        	</span>
	      		</div>
	        </div>

	      	

	         <div className="Stats">
	    			<div className="infos">
	          			<span className="messages_titre">Messages</span>
	          			<span className="messages_nombre">{this.props.twists}</span>
	      			</div>
	      			<div className="infos">
	            		<span className="abonnements_titre">Abonnements</span>
	            		<span className="abonements_titre">{this.props.abonements}</span>
	        		</div>
	        		<div className="infos">
	            		<span className="abonnés_titre">Abonnés</span>
	            		<span className="abonnés_nombre">{this.props.abonnés}</span>
	        		</div>
	        </div>
	    </div>
	</div>);
}

}
export default Profil_square;
