import { useParams } from "react-router-dom";
import PropertyDetails from "../../components/property/property";
import Footer from "../utils/footer";
import NavigationBar from "../utils/toolbar";

const Property = () => {
    const { id } = useParams();

    return (
        <>
            <NavigationBar />

            <PropertyDetails id={id} />

            <Footer />
        </>
    )
}

export default Property;