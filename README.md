# КиноНавигатор

Учебный проект по дисциплине «Жизненный цикл разработки программного обеспечения».

Автор: Артём Фалько, группа 450504.

## Тема

Веб-приложение для учёта просмотренных фильмов и выдачи персональных рекомендаций. Серверная часть разрабатывается на Java.

## Лабораторная работа № 3

- [заполненная спецификация требований](srs/srs.md);
- [исходный шаблон из ветки lab1](srs/srs-template.md);
- [мокап каталога](srs/figures/catalog.png) и [исходник SysML v2](srs/figures/sysmlv2/catalog.sysml);
- [мокап карточки фильма](srs/figures/movie-details.png) и [исходник SysML v2](srs/figures/sysmlv2/movie-details.sysml);
- [мокап рекомендаций](srs/figures/recommendations.png) и [исходник SysML v2](srs/figures/sysmlv2/recommendations.sysml).

Мокапы иллюстрируют визуальную концепцию интерфейса, а нормативные требования содержатся в SRS.

## Лабораторная работа № 5

- [глоссарий](docs/glossary.md);
- [дополнительные спецификации](docs/additional-specs.md);
- [описания акторов и вариантов использования](docs/use-case-specifications.md);
- [обновлённое описание дизайна](sdd/sdd.md);
- [обновлённое архитектурное решение](adr/adr.md).

UML-модель содержит по одной диаграмме каждого требуемого вида:

| Диаграмма | PlantUML | Изображение |
|---|---|---|
| Варианты использования | [use-case.puml](uml/use-case.puml) | [use-case.png](uml/images/behavior/use-case.png) |
| Активность | [activity.puml](uml/activity.puml) | [activity.png](uml/images/behavior/activity.png) |
| Состояния | [state.puml](uml/state.puml) | [state.png](uml/images/behavior/state.png) |
| Последовательность | [sequence.puml](uml/sequence.puml) | [sequence.png](uml/images/behavior/sequence.png) |

## Лабораторная работа № 6

Статическая структура «КиноНавигатора» описана в [SDD, DV-012](sdd/sdd.md#312-статическая-uml-модель). Механизмы построения и связи диаграмм пояснены в [ADR-001](adr/adr.md#статическая-uml-модель).

| Диаграмма | Редактируемый исходник | PNG | PDF |
|---|---|---|---|
| Классы «КиноНавигатора» | [PlantUML](uml/classes.puml) | [Изображение](uml/images/structural/classes.png) | [PDF](uml/images/structural/classes.pdf) |
| Компоненты модульного монолита | [Visio](uml/components.vsdx) | [Изображение](uml/images/structural/components.png) | [PDF](uml/images/structural/components.pdf) |
| Состав поставки и размещение в JVM | [Visio](uml/deployment.vsdx) | [Изображение](uml/images/structural/deployment.png) | [PDF](uml/images/structural/deployment.pdf) |

PNG и PDF динамических диаграмм хранятся в `uml/images/behavior/`, статических — в `uml/images/structural/`. Актуальные редактируемые исходники компонентов и развёртывания — файлы Visio; прежние PlantUML-варианты удалены.

## Состояние проекта

SDD версии 0.6 объединяет динамическую модель и согласованное описание текущих статических диаграмм. Maven-заготовка веб-приложения находится в `KinoNavigator/`.
