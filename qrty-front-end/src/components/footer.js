import React from 'react'

class Footer extends React.Component{
    render(){
        return <div id="footerWrapper">
            <footer>
                <div id="socialMedia">
                    <a><h5>Facebook</h5></a>
                    <a><h5>Twitter/X</h5></a>
                    <a><h5>Instagram</h5></a>
                </div>
                <div id="Footer Content">
                    <p>This is just a test</p>
                </div>
                <div id="privacyInfo">
                    <p>Fake Privacy Info</p>
                </div>
            </footer>
        </div>;
    }
}
export default Footer;