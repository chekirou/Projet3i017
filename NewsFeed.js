import React, { Component } from 'react';
import Message from './Message'
class NewsFeed extends Component {
  	constructor(props)
  	{
  		super(props);
  	}
	render()
	{
		return (
			<div className="les_messages">
				{this.props.tweets.map(({pseudo, image, message}) =>
					Message({pseudo, image, message})
					
				)}
			</div>


			)
	}
}

export default NewsFeed;