class Computer {
    constructor(
        public cpu: string,
        public ram: number,
        public storage: number,
        public gpu: string
    ) {}
}

class ComputerBuilder {
    private cpu: string = "";
    private ram: number = 0;
    private storage: number = 0;
    private gpu: string = "";

    setCPU(cpu: string): this {
        this.cpu = cpu;
        return this;
    }

    setRAM(ram: number): this {
        this.ram = ram;
        return this;
    }

    setStorage(storage: number): this {
        this.storage = storage;
        return this;
    }

    setGPU(gpu: string): this {
        this.gpu = gpu;
        return this;
    }

    build(): Computer {
        return new Computer(
            this.cpu,
            this.ram,
            this.storage,
            this.gpu
        );
    }
}

const computer = new ComputerBuilder()
    .setCPU("Intel i7")
    .setRAM(16)
    .setStorage(512)
    .setGPU("NVIDIA GTX 1660")
    .build();

