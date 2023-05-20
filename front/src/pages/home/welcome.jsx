import React from 'react';
import { Container, Typography } from '@material-ui/core';


const WelcomeText = () => {

    return (
        <>
           <main>
                <Container maxWidth='sm' style={{ marginTop:'100px', marginBottom:'50px' }}>
                    <Typography variant='h2' align='center' color='textPrimary' gutterBottom>
                        Imobiliária Digital
                    </Typography>
                    <Typography variant='h5' align='center' color='textSecondary' paragraph>
                        Para você que está procurando um imóvel, estamos aqui para ajudar
                    </Typography>
                </Container>
           </main>
        </>
    )
}

export default WelcomeText;