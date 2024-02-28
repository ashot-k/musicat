const Footer = () => {
    return (
        <footer>
            <hr/>
            <div className="footer-content">
                <div className="container">
                    <div className="d-flex justify-content-evenly">
                        <div className="col-md-4">
                            <h3>Contact Us</h3>
                            <p>123 Street, City</p>
                            <p>Phone: +1 123-456-7890</p>
                            <p>Email: info@example.com</p>
                        </div>
                        <div className="col-md-4">
                        </div>
                        <div className="col-md-4">
                            <p>Phone: +1 123-456-7890</p>
                            <p>Email: info@example.com</p>
                        </div>
                    </div>
                </div>
                <div className="footer-bottom">
                    <div className="container">
                        <div className="col-md-12">
                            <p>&copy; 2024 Musicat. All rights reserved.</p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    );
};

export default Footer;