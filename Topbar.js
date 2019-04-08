import React, { Component } from 'react';
import './Topbar.css';
class Topbar extends Component {
  constructor(props)
  {
  	super(props);
  	this.handleDeco = this.handleDeco.bind(this);
  }
  handleDeco(event) {
    this.props.signOut()
  }
	render()
	{
	return(
		<div className="topbarConteneur">
			<div className="topbarConteneur2">
				<div className="topbarConteneur3">
					<div className="topbarConteneur4">
						<span className="home_notif">
							<img  id="home" src="https://cdn4.iconfinder.com/data/icons/pictype-free-vector-icons/16/home-512.png" alt="profil"/> 
							<img id="notifs" src="https://cdn1.iconfinder.com/data/icons/ui-22/24/391-512.png" alt="notification" />
						</span>
						<img className="icone" src="https://www.brandcrowd.com/gallery/brands/pictures/picture12632215544704.jpg" alt="logo"/>
						<form>
							<input className="inputSearch" type="text" name="search"/>
							<input className="bouton" type="hidden"/>
						</form>
						<img id="deco" src="https://png.pngtree.com/svg/20160517/96e893609e.png" alt="deconnexion" onClick={this.handleDeco}/>
						
					</div>
				</div>
			</div>

		</div>

		)
}

}
export default Topbar;