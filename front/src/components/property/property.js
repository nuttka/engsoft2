import { Button, Card, CardActions, CardContent, CardMedia, Container, Typography } from "@material-ui/core";
import { Component } from "react";

const styles = theme => ({
    cardGrid: {
        padding: '20px 0 0',
        marginTop: '20px'
    },
    
    card: {
        height: '100%',
        display: 'flex',
        marginTop: '500px'
    },
    
    cardMedia: {
        paddingTop: '56.25%' //16:9
    },
    
    cardContent: {
        flexGrow: 1
    },
});


class PropertyDetails extends Component {
    constructor() {
        super();
        this.state = {
            isLoaded: false,
            property: {}
        };
    }

    componentDidMount() {
        const { id } = this.props;

        fetch('https://localhost:7126/api/v1/Property/' + id)
            .then(res => res.json())
            .then(json => {
                this.setState({
                    isLoaded: true,
                    property: json,
                    id: id
                });
            })
            .then(() => console.log('Property are loaded .. ', this.state.property));
    }

    render() {

        return (
            <main>
                <Container maxWidth="md">
                    <Card className={styles.card}>
                        <CardMedia
                            className={styles.cardMedia}
                            image={ this.state.property.imageURL }
                            title="random title"
                        />
                        <CardContent className={styles.cardContent}>
                            <Typography variant="h5">
                                { this.state.property.name }
                            </Typography>
                            <Typography variant="p">
                                <p>{ this.state.property.description }</p>
                            </Typography>
                            <Typography variant="p">
                                <p>Quantidade de quartos: { this.state.property.roomCount }</p>
                            </Typography>
                            <Typography variant="p">
                                <p>Localização: { this.state.property.address }</p>
                            </Typography>
                            <Typography variant="p">
                                <p>Vagas na garagem: { this.state.property.parkingCount }</p>
                            </Typography>
                            <Typography variant="p">
                                <p>Comercial: { this.state.property.isCommercial ? "Sim" : "Não" }</p>
                            </Typography>
                            <Typography variant="p">
                                <p>Contato do vendedor: { this.state.property.contactInfo }</p>
                            </Typography>
                        </CardContent>
                        {/* <CardActions>
                            <Button size="small" color="primary">
                                Visualizar
                            </Button>
                        </CardActions> */}
                    </Card>
                </Container>
            </main>
        )
    }
}

  
export default PropertyDetails;