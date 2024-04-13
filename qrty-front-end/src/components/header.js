import React from 'react';
import logo from './logo.svg';
class Header extends React.Component{
    render() {
        return <div id="navWrapper">

        <a href="index.html"><img src={logo} id="logo"></img></a>

        <div id="navContainer">
            <nav>
                <div className="navButtonWrapper">
                    <a href="index.html"><div className="navButton"><h2 className="navTitle">Placeholder 1</h2></div></a>
                    <a href="index.html"><div className="navButton"><h2 className="navTitle">Placeholder 2</h2></div></a>
                    <a href="index.html"><div className="navButton"><h2 className="navTitle">Placeholder 3</h2></div></a>
                </div>       
            </nav>
        </div>

        <div id="infoContainer">
            <div id="infoButtonContainer">
                <a href="index.html"><div className="navButton"><span className="navTitle">Sign In</span></div></a>
                <a href="index.html"><div className="navButton"><span className="navTitle">Contact</span></div></a>
            </div>
        </div>           
    </div>;
    }
}
export default Header;