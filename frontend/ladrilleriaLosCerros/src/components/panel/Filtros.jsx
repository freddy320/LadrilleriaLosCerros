import { useState } from "react";
import { CiSearch } from "react-icons/ci";
import { CiFilter } from "react-icons/ci";
import { SlArrowDown } from "react-icons/sl";



const Combobox = ({ title, options ,defaultValue}) => {
    const [isOpen, setIsOpen] = useState(false); 
    const [selectedOption, setSelectedOption] = useState(defaultValue); 
  
    const toggleDropdown = () => {
      setIsOpen(!isOpen);
    };

    const selectOption = (option) => {
      setSelectedOption(option);
      setIsOpen(false); 
    };
  
    return (
      <div className="relative flex items-center">
        <header className="px-2 text-lg">
            <h4>{title}: </h4>
        </header>
        <div className="relative">
        <button
          onClick={toggleDropdown}
          className="flex gap-2 items-center justify-center basis-48"
        >
          {selectedOption} <SlArrowDown className="scale-125" />
        </button>
  
        {isOpen && (
          <ul className="absolute bg-white shadow-lg rounded-lg mt-0.5 w-max z-10">
            <li  onClick={() => selectOption(defaultValue)} className="p-2 transition duration-500 hover:bg-themePage hover:text-white cursor-pointer">
              {defaultValue}
            </li>
            {options.map((option, index) => (
              <li
                key={index}
                onClick={() => selectOption(option)}
                className="p-2 transition duration-500 hover:bg-themePage hover:text-white cursor-pointer"
              >
                {option}
              </li>
            ))}
          </ul>
        )}
        </div>
      </div>
    );
  };

export default function Filtros({ title }) {
    const handleSubmit = (e) => {
        e.preventDefault();
    }

    return (
        <main className="">
            <section className="flex justify-center gap-9">
                <header className="flex gap-2 justify-center items-center">
                    <h2 className="text-center"><CiFilter className="scale-150 text-3xl"/></h2>
                    <h2 className="text-base font-semibold text-center">{title}</h2>
                </header>
                <form className="" onSubmit={handleSubmit}>
                    <div className="flex gap-5">
                        <Combobox title="Sucursal" options={['San Miguel']} defaultValue="Los Cerros" />
                        <Combobox title="Año" options={[2021, 2022, 2023]} defaultValue="2024" />
                        <Combobox title="Mes" options={['Enero', 'Febrero', 'Marzo','Abril','Mayo','Junio','Julio','Septiembre','Octubre','Noviembre']} defaultValue="Todos" />
                        <button className="bg-themePage rounded-xl p-2 flex gap-2 items-center justify-center  text-contrast
                            hover:bg-themePageDark hover:text-contrast focus:outline-none font-semibold
                        ">
                            Aplicar <CiSearch  className="font-semibold scale-125"/>
                        </button>
                    </div>                    
                </form>
            </section>
        </main>
    );
}
