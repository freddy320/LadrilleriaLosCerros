import { useState } from "react";
import { BiSolidDownArrow } from "react-icons/bi";

const ComboBox = ({ opcions }) => {
    const [isActive, setActive] = useState(false);
    const [selected, setSelected] = useState(opcions[0]);
    const handleClick = (value) => {
        setActive(!isActive);
        setSelected(value);
    }
    return (
        <div className="flex flex-col absolute top-6 right-1 mx-5 my-2">
            {
                isActive ? opcions.map((opc) => (
                    <div onClick={() => handleClick(opc)} key={opc} className="flex justify-center rounded-xl transition duration-500 bg-themePage items-center w-24 gap-3 p-2 font-medium text-contrast  cursor-pointer hover:bg-themePageDark">
                        {opc}<BiSolidDownArrow />
                    </div>
                ))
                    :
                    <div onClick={() => setActive(!isActive)} className="flex justify-center rounded-xl transition duration-500 bg-themePage items-center w-24 gap-3 p-2 font-medium hover:bg-themePage text-contrast cursor-pointer hover:bg-themePageDark">
                        {selected}<BiSolidDownArrow />
                    </div>
            }
        </div>
    )
}
export default ComboBox;