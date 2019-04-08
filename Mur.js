import React, { Component } from 'react';

import Login from './Login';
import Logout from './Logout';
import NewsFeed from './NewsFeed'
import Topbar from './Topbar'
import Profil_square from './Profil_square'
import NewMessage from './NewMessage'
import './Mur.css';
class Mur extends Component {
  constructor()
  {
  	super()
  }
  render()
  {
  	
    const infos = {
    			profilPic:"https://images.unsplash.com/photo-1518806118471-f28b20a1d79d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80",
    			nom: "chekirou",
    			prenom: "hakim",
    			login: "the_darkling99",
    			twists: 2000,
    			abonements: 12,
    			abonnés: 6000
    }
  	return (
  		<div className="tout">
  			<Topbar signOut={this.props.disconnect}/>
  			<div className="part2">
  			<div className="side">
  				<Profil_square
  				profilPic={infos.profilPic}
  				nom={infos.nom}
  				prenom = {infos.prenom}
  				login={infos.login}
  				twists={infos.twists}
  				abonements = {infos.abonements}
  				abonnés={infos.abonnés}
  				 />
  			</div>
  			<div className="main">
  			<NewsFeed tweets={this.props.tweets}/>
  			</div>
  			<div className="nouveau">
  			<NewMessage />
  			</div>
  			</div>
  			
  		</div>



  		)
  }

}
export default Mur;