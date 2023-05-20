import React from 'react';
import NavigationBar from '../utils/toolbar';
import Properties from '../../components/properties/properties';
import WelcomeText from './welcome';
import Footer from '../utils/footer';

const Home = () => {
    return (
        <>
            <NavigationBar />
            <WelcomeText />
            <Properties />
            <Footer />
        </>
    )
}

export default Home;