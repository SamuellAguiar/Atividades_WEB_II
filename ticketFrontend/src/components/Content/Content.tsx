// import "../../styles/Content.css"
import Filter from "../Filter/Filter"
import MainBlock from "../MainBlock/MainBlock"
import MenuBlock from "../MenuBlock/MenuBlock"

const Content = () => {
    return(
        <div>
            <MenuBlock></MenuBlock>
            <Filter></Filter>
            <MainBlock></MainBlock>
        </div>
    )
}

export default Content